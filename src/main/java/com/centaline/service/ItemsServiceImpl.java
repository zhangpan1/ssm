package com.centaline.service;

import com.centaline.dao.ItemsMapper;
import com.centaline.pojo.Items;
import com.centaline.pojo.ItemsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangpan on 2019/10/14.
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> list() throws Exception {
		// 如果不需要任何查询条件，直接将example对象new 出来即可
		ItemsExample example = new ItemsExample();
		List<Items> itemsList = itemsMapper.selectByExampleWithBLOBs(example);
		return itemsList;
	}

	@Override
	public Items findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItems(Items items) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
