package cn.edu.tit.iservice.iserviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.tit.bean.RecruitInfo;
import cn.edu.tit.bean.User;
import cn.edu.tit.common.Common;
import cn.edu.tit.idao.IUserDao;
import cn.edu.tit.iservice.IUserService;

/**
 * @author LiMing
 * 管理员功能模块
 * */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao iUserDao;

	/**
	 * @author 
	 * 增加用户信息
	 * */
	@Override
	public void addUser() throws Exception {

	}

	/**
	 * @author 
	 * 更新用户信息
	 * */
	@Override
	public void updateUser() throws Exception {
		
	}

	/**
	 *@author LiMing
	 * @param recruit
	 * 发布招聘信息
	 */
	@Override
	public void publishRcruit(RecruitInfo recruit)throws Exception {
		try {
			iUserDao.publishRcruit(recruit);
			System.out.println("publishRcruit-------------执行成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("publishRcruit-------------执行失败");
		}
	}

	/**
	 *@author LiMing
	 * @param 当参数(publisherId)为空时,查询所有招聘信息.
	 * @param 当参数(publisherId)不空时,条件查询该ID下的招聘信息
	 * @return 获取所有招聘信息
	 */
	@Override
	public List<RecruitInfo> getRecruitInfo(String publisherId) {
		List<RecruitInfo> list =new ArrayList<RecruitInfo>();
		try {
			list = iUserDao.getRecruitInfo(publisherId);
			System.out.println("getRecruitInfo-------------执行成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getRecruitInfo-------------执行失败");
			list = null;
		}
		return list;
	}

	/**
	 * @author LiMing
	 * @param 单位名
	 * @return 按照单位名查找招聘信息
	 */
	@Override
	public List<RecruitInfo> searchRecruit(String search) {
		List<RecruitInfo> list =new ArrayList<RecruitInfo>();
		try {
			list = iUserDao.searchRecruit(search);
			System.out.println("searchRecruit-------------执行成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchRecruit-------------执行失败");
			list = null;
		}
		return list;
	}
}