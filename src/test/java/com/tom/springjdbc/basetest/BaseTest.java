package com.tom.springjdbc.basetest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-module.xml") 
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) 
public class BaseTest {

}
