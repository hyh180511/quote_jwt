package com.demo.quote.service.service;

import com.demo.quote.pojo.ProjectInfo;

public interface UserService {

    public Object loadUser();

    public ProjectInfo loadProjectInfoById(int proId);
}
