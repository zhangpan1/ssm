package com.centaline.controller;

import com.centaline.pojo.Items;
import com.centaline.service.ItemsService;
import com.centaline.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangpan on 2019/10/14.
 */
@Controller
public class ItemsController {
	/**
	 * 使用注解的形式
	 * @Resource
	 * @Autowired 自动注入  --一个接口如果有两个实现类 就不能用Autowired
	 * 二者有啥区别----面试题（两个都行）
	 *
	 */
	@Autowired
	private ItemsService itemsService;
	@RequestMapping("/list")
	public ModelAndView itemsList() throws Exception{
		List<Items> list = itemsService.list();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList",list);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	@RequestMapping("/itemEdit")
	public String itemEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception{
		String idStr = request.getParameter("id");
		Items item = itemsService.findItemsById(Integer.parseInt(idStr));
		// Model模型：模型中放入了返回给页面的数据
		// model 底层 其实用的就是request域来传递数据，但是对request进行了拓展
		model.addAttribute("item",item);
		// 如果springMvc方法返回一个简单的String字符串，那么springMvc就会认为这个字符串就是页面的名称
		return "editItem";
	}

	/**
	 * mvc 直接接收基本类型   自动帮忙转换 类型
	 * controller方法接收的参数类型的名称必须等于页面上Input的name属性值
	 * 接收高级查询参数
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateitem")
	public String update(Items items) throws Exception{
		items.setCreatetime(new Date());
		itemsService.updateItems(items);
		return "success";
	}
	@RequestMapping("/search")
	public String search(QueryVo queryVo) throws Exception{
		//<!--如果controller中接收的是VO,那么页面上 input框的name 属性值 要等于vo的属性.属性.属性.属性-->
		System.out.println(queryVo);
		return "";
	}
	@RequestMapping("/delAll")
	public String delAll(QueryVo vo) throws Exception{
		// 如果批量删除，一堆input框，那么可以提交数组，（只有input 复选框被选中的时候才能提交）
		System.out.println(vo);
		return "";
	}

	/**
	 * 批量修改
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateAll")
	public String updateAll(QueryVo vo) throws Exception{
		// 如果批量删除，一堆input框，那么可以提交数组，（只有input 复选框被选中的时候才能提交）
		System.out.println(vo);
		return "";
	}



}
