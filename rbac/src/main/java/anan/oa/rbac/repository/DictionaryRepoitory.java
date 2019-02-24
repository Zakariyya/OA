package anan.oa.rbac.repository;

import anan.oa.rbac.orm.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryRepoitory extends JpaRepository<Dictionary, Integer> {

  List<Dictionary> findAllByDictType(String dictType);

  Dictionary findAllByDictTypeAndOptionValue(String dictType, String optionValue);
}
