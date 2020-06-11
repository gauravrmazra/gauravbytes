import React from 'react';
import './App.css';
import BlogPosts from './components/BlogPosts';
import IBlogPost from './models/IBlogPost';

const POSTS: IBlogPost[] = [
  {
    id: 1,
    title: 'Spring JDBC returning auto-generated keys using PreparedStatementCreator and PreparedStatementCallback',
    content: `In this post, we will look into how to retrieve auto-generated keys in JDBC. We will also explore usage of PreparedStatementCreator and PreparedStatementCallback in JdbcTemplate.

    There are cases when you rely on Database server to auto generate values for some columns of the table. E.g. auto increment primary key, creation_date or any other column while inserting records. There is a way with which you can retrieve those auto-generated keys when you execute the insert statement. Let's see how you can do this using Spring JDBC but first we will see what PreparedStatementCreator and PreparedStatementCallback interfaces are.
    
    What is PreparedStatementCreator?
    There are cases when you want to create PreparedStatement yourself. One use case is to return auto generated keys. In that case, Spring JDBC provides you an option to do so by providing implementation for PreparedStatementCreator. Let's create an implementation of PreparedStatementCreator which sets those options.`,
    author: 'Gaurav Mazra',
    postedOn: 'January 06, 2019',
    tags: [
      'auth-generated keys jdbc',
      'PreparedStatementCallback spring jdbc',
      'spring jdbc'
    ]
  },
  {
    id: 2,
    title: 'Data Analytics: Watching and Alerting on real-time changing data in Elasticsearch using Kibana and SentiNL',
    content: `In the previous post, we have setup ELK stack and ran data analytics on application events and logs. In this post, we will discuss how you can watch real-time application events that are being persisted in the Elasticsearch index and raise alerts if condition for watcher is breached using SentiNL (Kibana plugin).

    Few examples of alerting for application events (see previous posts) are:
    
    Same user logged in from different IP addresses.
    Different users logged in from same IP address.
    PermissionFailures in last 15 minutes.
    Particular kind of exception in last 15 minutes/ hour/ day.
    Watching and alerting on Elasticsearch index in Kibana
    There are many plugins available for watching and alerting on Elasticsearch index in Kibana e.g. X-Pack, SentiNL.
    
    X-Pack is a paid extension provided by elastic.co which provides security, alerting, monitoring, reporting and graph capabilities.
    
    SentiNL is free extension provided by siren.io which provides alerting and reporting functionality to monitor, notify and report changes in elasticsearch index using standard queries, programmable validators and configurable actions.`,
    author: 'Gaurav Mazra',
    postedOn: 'October 09, 2018',
    tags: [
      'alerting',
      'data analytics',
      'elasticsearch',
      'kibana',
      'logstash',
      'reporting using SentiNL',
      'alerting on elasticsearch index'
    ]
  },
  {
    id: 3,
    title: 'Java 8 - default and static methods in interfaces',
    content: `Java 8 introduced default and static methods in interfaces. These features allow us to add new functionality in the interfaces without breaking the existing contract for implementing classes.

    How do we define default and static methods?
    Default method has default and static method has static keyword in the method signature.
    Few important points for default method
    - You can inherit the default method.
    - You can redeclare the default method essentially making it abstract.
    - You can redefine the default method (equivalent to overriding).
    `,
    author: 'Gaurav Mazra',
    postedOn: 'August 23, 2018',
    tags: [
      'java 8 default and static methods',
      'java 8',
      'core java'
    ]
  },
  {
    id: 4,
    title: 'Apache Ignite - Examples on Data grid, compute grid, service grid and executing SQL queries',
    content: `In this article, we will show few examples on using Apache Ignite as Compute Grid, Data Grid, Service Grid and executing SQL queries on Apache Ignite. These are basic examples and use the basic api available. There will be few posts in near future which explains the available API in Compute Grid, Service Grid and Data Grid.

    Ignite SQL Example
    Apache Ignite comes with JDBC Thin driver support to execute SQL queries on the In memory data grid. In the example below, we will create tables, insert data into tables and get data from tables. I will assume that you are running Apache Ignite on your local environment otherwise please read setup guide for running Apache Ignite server.`,
    author: 'Gaurav Mazra',
    postedOn: 'February 09, 2018',
    tags: [
      'apache ignite examples',
      'in-memory data grid',
      'compute grid'
    ]
  },
  {
    id: 5,
    title: 'Single Responsibility principle with example',
    content: `Single responsibility principle was introduced by Tom DeMarco in his book "Structured Analysis and Systems Specification, 1979". Robert Martin reinterpreted the concept and defined the responsibility as a reason to change.
    A class should have only one reason to change.
    In this context, responsibility is considered as reason to change. This principle states that if we have two reasons to change for a class, we have to split the functionality in two classes. Each class will handle only one responsibility and on future if we need to make one change we are going to make it in the class which handles it. When we need to make a change in the class having more responsibilities the change might affect the other functionality of the classes.`,
    author: 'Kumar Saurabh',
    postedOn: 'October 01, 2014',
    tags: [
      'software design principles',
      'single responsiblity principle'
    ]
  }
]


function App() {
  return (
    <div className="App-Container">
      <BlogPosts posts={POSTS}/>
    </div>
  );
}

export default App;
