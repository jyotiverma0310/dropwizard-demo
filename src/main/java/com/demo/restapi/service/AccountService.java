package com.demo.restapi.service;

import com.codahale.metrics.annotation.Timed;
import com.demo.restapi.daoimpl.AccountDaoImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountService {

    private AccountDaoImpl accountDaoImpl;

    @Inject
    public AccountService(AccountDaoImpl accountDaoImpl) {
        this.accountDaoImpl = accountDaoImpl;
    }


    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        return accountDaoImpl.getAll();
    }

    @GET
    @Timed
    @Path("/save")
    public void save() {
        accountDaoImpl.save();
    }

}
