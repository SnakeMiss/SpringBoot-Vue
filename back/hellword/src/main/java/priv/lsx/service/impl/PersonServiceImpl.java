package priv.lsx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.lsx.entity.Persons;
import priv.lsx.service.PersonService;

import priv.lsx.mapper.PersonMapper;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Persons> implements PersonService {
}
