package com.oa.user.service;

import java.util.List;

import com.oa.user.entity.UserMemory;
import com.oa.user.vo.Memory;

public interface UserMemoryService {
int insertObject(UserMemory memory);
List<Memory> findObjects(String username);
int deleteObjects(String username,String date);
}
