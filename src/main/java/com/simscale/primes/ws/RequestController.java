package com.simscale.primes.ws;

import com.simscale.primes.algorithm.LogGenerator;
import com.simscale.primes.algorithm.SieveGenerator;
import com.simscale.primes.algorithm.StraightGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/primes")
public class RequestController {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/straight", method = RequestMethod.POST)
    public @ResponseBody
    List<Integer> getPrimesByStraight(@RequestBody Request r) {
        long timeBefore = System.currentTimeMillis();
        ArrayList<Integer> primes = new StraightGenerator().generate(r.getStart(), r.getEnd());
        long timeAfter= System.currentTimeMillis();

        jdbcTemplate.update("INSERT INTO requests(timestamp, start,end, time_elapsed, algorithm_type, num_of_primes) VALUES(?,?,?,?,?,?)",
                new Object[]{timeBefore, r.getStart(), r.getEnd(), timeAfter - timeBefore, "straight", primes.size()});

        return primes;
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public @ResponseBody
    List<Integer> getPrimesByLog(@RequestBody Request r) {
        long timeBefore = System.currentTimeMillis();
        ArrayList<Integer> primes = new LogGenerator().generate(r.getStart(), r.getEnd());
        long timeAfter= System.currentTimeMillis();

        jdbcTemplate.update("INSERT INTO requests(timestamp, start,end, time_elapsed, algorithm_type, num_of_primes) VALUES(?,?,?,?,?,?)",
                new Object[]{timeBefore, r.getStart(), r.getEnd(), timeAfter - timeBefore, "log", primes.size()});

        return primes;
    }

    @RequestMapping(value = "/sieve", method = RequestMethod.POST)
    public @ResponseBody
    List<Integer> getPrimesBySieve(@RequestBody Request r) {
        long timeBefore = System.currentTimeMillis();
        ArrayList<Integer> primes = new SieveGenerator().generate(r.getStart(), r.getEnd());
        long timeAfter= System.currentTimeMillis();

        jdbcTemplate.update("INSERT INTO requests(timestamp, start,end, time_elapsed, algorithm_type, num_of_primes) VALUES(?,?,?,?,?,?)",
                new Object[]{timeBefore, r.getStart(), r.getEnd(), timeAfter - timeBefore, "sieve", primes.size()});

        return primes;
    }


}