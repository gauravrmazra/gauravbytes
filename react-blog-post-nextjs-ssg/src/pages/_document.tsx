import React from 'react';
import Document, { Html, Head, Main, NextScript } from 'next/document'

export default class MyDocument extends Document {
  render() {
    return (
    <Html lang="en">
      <Head>
        <meta content='Tutorials for Java, Java 8, Spring, Spring Cloud, Spring Boot, Apache Avro, concurrency, Design patterns,  Executor Framework, Java concurrency' name='description'/>
        <meta content='https://www.codefoundry.dev/' property='og:url'/>
        <meta content='Gaurav Bytes' property='og:title'/>
        <meta content='Tutorials for Java, Java 8, Spring, Spring Cloud, Spring Boot, Apache Avro, concurrency, Design patterns,  Executor Framework, Java concurrency' property='og:description'/>
        <meta content='Java Programming, Spring framework, Spring Cloud, Spring Boot, Tutorials for Java, Apache Avro, Java concurrency, Java interview questions answers, Big Data, Data analytics, Elasticsearch, React, React JS, React Redux, Node.JS' name='keywords'/>
        <meta content='en_US' property='og:locale'/>
        <meta content='en_GB' property='og:locale:alternate'/>
        <meta content='Canada' name='geo.placename'/>
        <meta content='Gaurav Rai Mazra' name='Author'/>
        <meta content='general' name='rating'/>
        <meta content='Gaurav Bytes' property='og:title'/>
        <meta content='website' property='og:type'/>
        <meta content='https://www.codefoundry.dev/' property='og:url'/>
        <meta content='https://www.codefoundry.dev/favicon.ico' property='og:image'/>
        <meta content='Tutorials for Java, Java 8, React JS, React Redux, Next JS, Spring, Spring Cloud, Spring Boot, Apache Avro, concurrency, Design patterns,  Executor Framework, Java concurrency' property='og:description'/>
        <meta content='Gaurav Bytes' property='og:site_name'/>
      </Head>
      <body>
        <Main />
        <NextScript />
      </body>
    </Html>
    )
  }
}