package EntityP.person.dao;

import java.util.List;

import EntityP.person.person;

public interface persondao {
	
	/**
	 * 1.病人的登记
	 */
	//就是插入数据
	boolean Personrecord(person person) throws Exception;
	
	
	/**
	 * 2.病人就诊
	 * 
	 */
	//根据症状，进行数据的更新。
	boolean curePerson(person person) throws Exception;
	/**
	 * 3.病李查询
	 */
	List<person> personQuery() throws Exception;
	List<person> personQuery(String idCard) throws Exception;//可以根据身份证号进行查询
	List<person> personQuery(int id) throws Exception;//可以根据病历号进行查询
	/**
	 * 4.修改病历
	 */
	boolean updatePersonMsg(person person) throws Exception;
	
	boolean updatePerson(person person) throws Exception;
	
	/**
	 * 5.删除病历
	 */
	boolean deletePersonMsg(int id) throws Exception;

	/**
	 * 6.打印输出病历信息
	 */
	boolean printrecord(person person) throws  Exception;
}
