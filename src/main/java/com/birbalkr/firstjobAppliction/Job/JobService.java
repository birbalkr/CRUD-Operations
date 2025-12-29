package com.birbalkr.firstjobAppliction.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean getDeleteJob(Long id);

    boolean updateJob(Long id, Job updated);
}

