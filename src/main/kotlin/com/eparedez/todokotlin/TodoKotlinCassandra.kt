package com.eparedez.todokotlin

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.core.CassandraOperations
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.data.cassandra.core.convert.CassandraConverter
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@Configuration
@EnableCassandraRepositories("com.eparedez.todokotlin.models.repositories")
class TodoKotlinCassandra {

    companion object {
        const val KEY_SPACE_NAME = "keyspacenotes"
    }

    @Value("\${noteka.cassandra.contactpoints}")
    lateinit var CASSANDRA_URL: String

    @Bean
    fun cluster() : CassandraClusterFactoryBean {
        val cluster = CassandraClusterFactoryBean()
        cluster.setContactPoints(CASSANDRA_URL) //TODO change to .properties
        cluster.setJmxReportingEnabled(false)
        return cluster
    }

    @Bean
    fun mappingContext() : CassandraMappingContext{
        val mappingContext = BasicCassandraMappingContext()
        mappingContext.setUserTypeResolver(SimpleUserTypeResolver(cluster().`object`, KEY_SPACE_NAME)) //TODO change to .properties
        return mappingContext
    }

    @Bean
    fun convert() : CassandraConverter{
        return MappingCassandraConverter(mappingContext())
    }

    @Bean
    fun session(): CassandraSessionFactoryBean{
        val session = CassandraSessionFactoryBean()
        session.setCluster(cluster().`object`)
        session.setKeyspaceName(KEY_SPACE_NAME)
        session.setConverter(convert())
        session.schemaAction = SchemaAction.NONE
        return session
    }

    @Bean
    fun cassandraTemplate() : CassandraOperations{
        return CassandraTemplate(session().`object`)
    }

}