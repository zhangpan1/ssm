package com.centaline.service;

import com.centaline.dao.ItemsMapper;
import com.centaline.pojo.Items;

import java.util.List;

/**
 * Created by zhangpan on 2019/10/14.
 */
public interface ItemsService {
	public List<Items> list() throws Exception;
	public Items findItemsById(Integer id) throws Exception;

	public void updateItems(Items items) throws Exception;
}
