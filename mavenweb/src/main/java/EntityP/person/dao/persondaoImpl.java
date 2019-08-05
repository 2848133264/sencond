package EntityP.person.dao;
import jxl.write.Label;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import EntityP.person.person;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import mavenweb.DBUtil.c3p0_DBUtils;

public class persondaoImpl implements persondao {

	@Override
	public boolean Personrecord(person person) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn =c3p0_DBUtils.getConnection();
		String sql ="insert into person(id,name,gender,age,isMarry,inDate,birthday,company,phone,idCard,address) values(?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setInt(1, person.getId());
		pstm.setString(2, person.getName());
		pstm.setString(3, person.getGender());
		pstm.setString(4, person.getAge());
		pstm.setString(5, person.getIsMarry());
		
		System.out.println(person.getIsMarry());
		
		pstm.setString(6, person.getInDate());
		pstm.setString(7, person.getBirthday());
		pstm.setString(8, person.getCompany());
		pstm.setString(9, person.getPhone());
		pstm.setString(10, person.getIdCard());
		pstm.setString(11, person.getAddress());	
		int num =pstm.executeUpdate();
		if(num > 0){
			System.out.println("添加成功");
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<person> personQuery() throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn =c3p0_DBUtils.getConnection();
		String sql ="select * from person";
		PreparedStatement pstm =conn.prepareStatement(sql);
		ResultSet rsSet =pstm.executeQuery(); 
		List<person> list =new ArrayList<person>();
		while (rsSet.next()) {
			int  id =rsSet.getInt(1);
			String  name =rsSet.getString(2);
			String  age =rsSet.getString(3);
			String  gender =rsSet.getString(4);
			String  isMarry =rsSet.getString(5);
			String  inDate =rsSet.getString(6);
			String  birthday =rsSet.getString(7);
			String  company =rsSet.getString(8);
			String  phone =rsSet.getString(9);
			String  idCard =rsSet.getString(10);
			String  address =rsSet.getString(11);
			String  bingshi =rsSet.getString(12);
			String  xianzhuang =rsSet.getString(13);
			String  result =rsSet.getString(14);
			list.add(new person(id, name, age, gender, isMarry, inDate, birthday, company, phone, idCard, address, bingshi, xianzhuang, result));
		}
		return list;
	}

	@Override
	public List<person> personQuery(String idCard) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn =c3p0_DBUtils.getConnection();
		String sql ="select * from person where idCard=?";
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setString(1, idCard);
		ResultSet rsSet =pstm.executeQuery(); 
		List<person> list =new ArrayList<person>();
		while (rsSet.next()) {
			int  id =rsSet.getInt(1);
			String  name =rsSet.getString(2);
			String  age =rsSet.getString(3);
			String  gender =rsSet.getString(4);
			String  isMarry =rsSet.getString(5);
			String  inDate =rsSet.getString(6);
			String  birthday =rsSet.getString(7);
			String  company =rsSet.getString(8);
			String  phone =rsSet.getString(9);
			String  idCard1 =rsSet.getString(10);
			String  address =rsSet.getString(11);
			String  bingshi =rsSet.getString(12);
			String  xianzhuang =rsSet.getString(13);
			String  result =rsSet.getString(14);
			list.add(new person(id, name, age, gender, isMarry, inDate, birthday, company, phone, idCard1, address, bingshi, xianzhuang, result));
		}
		return list;

	}

	@Override
	public List<person> personQuery(int id) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn =c3p0_DBUtils.getConnection();
		String sql ="select * from person where id=?";
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rsSet =pstm.executeQuery(); 
		List<person> list =new ArrayList<person>();
		while (rsSet.next()) {
			int  id1 =rsSet.getInt(1);
			String  name =rsSet.getString(2);
			String  age =rsSet.getString(3);
			String  gender =rsSet.getString(4);
			String  isMarry =rsSet.getString(5);
			String  inDate =rsSet.getString(6);
			String  birthday =rsSet.getString(7);
			String  company =rsSet.getString(8);
			String  phone =rsSet.getString(9);
			String  idCard1 =rsSet.getString(10);
			String  address =rsSet.getString(11);
			String  bingshi =rsSet.getString(12);
			String  xianzhuang =rsSet.getString(13);
			String  result =rsSet.getString(14);
			list.add(new person(id1, name, age, gender, isMarry, inDate, birthday, company, phone, idCard1, address, bingshi, xianzhuang, result));
		}
		return list;

	}

	//修改病历，能修改到什么层面，病历不能被修改（医院不能），诊断结果可以修改（某个时间段内是可以被修改的）
	@Override
	public boolean updatePersonMsg(person person) throws Exception {
		// TODO Auto-generated method stub
		Connection conn =c3p0_DBUtils.getConnection();
		//病历号不能被修改，其他的为所谓
		String sql ="update person set age =?,inDate=?,bingshi=?,xianzhuang=?,result=? where id=?";
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setString(1, person.getAge());
		pstm.setString(2, person.getInDate());
		pstm.setString(3, person.getBingshi());
		pstm.setString(4, person.getXianzhuang());
		pstm.setString(5, person.getResult());
		pstm.setInt(6, person.getId());
		int num =pstm.executeUpdate();
		if(num > 0){
			System.out.println("更新成功！");
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean deletePersonMsg(int id) throws Exception {
		// TODO Auto-generated method stub	
		/*
		 * 删除的方式是是什么，id，还是啥，id 是主键，可以当根据，
		 */
		Connection conn =c3p0_DBUtils.getConnection();
		String sql ="delete from person where id =?";
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setInt(1, id);
		int num =pstm.executeUpdate();
		if(num > 0){
			System.out.println("更新成功！");
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean curePerson(person person) throws Exception {
		// TODO Auto-generated method stub
		Connection conn =c3p0_DBUtils.getConnection();
		//病历号不能被修改，其他的为所谓
		String sql ="update person set name =?,gender=?,age =?,inDate=?,birthday=?,company=?,phone=?,idCard=?,address=?,result=?";
		PreparedStatement pstm =conn.prepareStatement(sql);
	
		pstm.setString(1, person.getName());
		pstm.setString(2, person.getGender());
		pstm.setString(3, person.getAge());
		pstm.setString(4, person.getIsMarry());
		pstm.setString(5, person.getInDate());
		pstm.setString(6, person.getBirthday());
		pstm.setString(7, person.getCompany());
		pstm.setString(8, person.getPhone());
		pstm.setString(9, person.getIdCard());
		pstm.setString(10, person.getAddress());	
		pstm.setString(11, person.getResult());
		int num =pstm.executeUpdate();
		if(num > 0){
			System.out.println("更新成功！");
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updatePerson(person person) throws Exception {
		// TODO Auto-generated method stub
				Connection conn =c3p0_DBUtils.getConnection();
				String sql ="update person set name =?,inDate=?,bingshi=?,xianzhuang=?,result=?,gender=?, phone=? where id=?";
				PreparedStatement pstm =conn.prepareStatement(sql);
				pstm.setString(1, person.getName());
				pstm.setString(2, person.getInDate());
				pstm.setString(3, person.getBingshi());
				pstm.setString(4, person.getXianzhuang());
				pstm.setString(5, person.getResult());
				pstm.setString(6, person.getGender());
				pstm.setString(7, person.getPhone());			
				pstm.setInt(8, person.getId());
				int num =pstm.executeUpdate();
				if(num > 0){
					System.out.println("更新成功！");
					return true;
				}else {
					return false;
				}
			}

	@Override
	public boolean printrecord(person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		//获得所有关于他的信息，将这些数据写在这个Excel 文件中去。
		//开始写入Excel 文件，创建文件头
		String [] titleA ={"序号","病历号","姓名","年龄","性别","身份证号","婚否","家庭住址","联系方式","就诊时间","病史","病状","就诊结果"};
		File fileA =new File("F:/pesonrecord.xls");
		if(fileA.exists()){
			fileA.delete();
		}
			fileA.createNewFile();
			//创建工作簿
			WritableWorkbook workbookA =Workbook.createWorkbook(fileA);
			//创建这个sheet 
			
			WritableSheet sheetA  =workbookA.createSheet("sheet1", 0);
			Label labelA =null;
			
			//设置列名
			for(int i=0;i<titleA.length;i++){
				labelA =new Label(i, 0,titleA[i]);
				sheetA.addCell(labelA);
			}
			//获得数据源
			//"病历号","姓名","年龄","性别","身份证号","婚否","家庭住址","联系方式","就诊时间","病史","病状","就诊结果"
			for(int i =1;i<2;i++){
				labelA =new Label(0, i, i+" ");
				sheetA.addCell(labelA);
				labelA =new Label(1, i, person.getId()+"");
				sheetA.addCell(labelA);
				labelA =new Label(2, i, person.getName());
				sheetA.addCell(labelA);
				labelA =new Label(3, i, person.getAge());
				sheetA.addCell(labelA);
				labelA =new Label(4, i, person.getGender());
				sheetA.addCell(labelA);
				labelA =new Label(5, i, person.getIdCard());
				sheetA.addCell(labelA);
				//婚否
				labelA =new Label(6, i, person.getIsMarry());
				sheetA.addCell(labelA);
				labelA =new Label(7, i, person.getAddress());
				sheetA.addCell(labelA);
				labelA =new Label(8, i, person.getPhone());
				sheetA.addCell(labelA);
				labelA =new Label(9, i, person.getInDate());
				sheetA.addCell(labelA);
				labelA =new Label(10, i, person.getBingshi());
				sheetA.addCell(labelA);
				labelA =new Label(11, i, person.getXianzhuang());
				sheetA.addCell(labelA);
				labelA =new Label(12, i, person.getResult());
				sheetA.addCell(labelA);
			}
			workbookA.write();//写入数据
			workbookA.close();//关闭资源
			System.out.println("数据写入成功");
			flag = true;
		    return flag;
	}
}
