package priv.lsx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import priv.lsx.entity.Persons;
import priv.lsx.entity.SelectQuery;
import priv.lsx.exception.UaiException;
import priv.lsx.service.PersonService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lsx
 * @since 2021-03-06
 */
@RequestMapping("/person")
@RestController
@CrossOrigin
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(value = "s/{current}/{size}")
    public Page<Persons> s(@PathVariable("current") Integer current, @PathVariable("size") Integer size, @RequestBody(required = false) SelectQuery selectQuery) {
        //  System.out.print(id+"1111111111111");
        Page<Persons> PersonsPage = new Page<>(current, size);
        QueryWrapper<Persons> queryWrapper = new QueryWrapper();

        //System.out.println(SelectQuery.toString());
        if (!(ObjectUtils.isEmpty(selectQuery))) {
            String name = selectQuery.getName();
            String begin = selectQuery.getCreateTime();
            String end = selectQuery.getUpdateTime();
            if (!(StringUtils.isEmpty(name))) {
                queryWrapper.like("name", name);
            }
            if (!(StringUtils.isEmpty(begin))) {
                queryWrapper.ge("time", begin);
            }
            if (!(StringUtils.isEmpty(end))) {
                queryWrapper.lt("time", end);
            }
            queryWrapper.orderByDesc("time");
            return personService.page(PersonsPage, queryWrapper);
        }

        return personService.page(PersonsPage);
    }

    @ApiOperation(value = "r", notes = "rPeson")
    @GetMapping(value = "/r/{id}")
    public Persons rPeson(@PathVariable("id") Long id) {
        return personService.getById(id);
    }

    @ApiOperation(value = "u", notes = "uPeson")
    @RequestMapping(value = "u", method = RequestMethod.POST)
    public boolean uPeson(@RequestBody Persons persons) {
        try {
            if ((!StringUtils.isEmpty(persons.getId()))) {
                return personService.updateById(persons);
            } else {
                return personService.save(persons);
            }
        } catch (UaiException e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }

    @ApiOperation(value = "d", notes = "dPeson")
    @DeleteMapping(value = "d/{id}")
    public boolean dPeson(@PathVariable("id") String id) {
        System.out.println("====================================" + id);
        return personService.removeById(id);
    }
}
