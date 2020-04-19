package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupService.getGroups();
    }

    @PostMapping(value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.create(groupDto);
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupService.update(groupDto);
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) {
        return groupService.getGroup(groupId);
    }
}
