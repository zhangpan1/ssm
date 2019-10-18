package com.centaline.vo;

import com.centaline.pojo.Items;

import java.util.List;

/**
 * Created by zhangpan on 2019/10/18.
 */
public class QueryVo {
	// 商品对象
	private Items items;
	// 订单对象。

	// 用户对象。
	// 批量删除使用
	private Integer[] ids;
	// 批量修改使用
	private List<Items> itemsList;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}
}
