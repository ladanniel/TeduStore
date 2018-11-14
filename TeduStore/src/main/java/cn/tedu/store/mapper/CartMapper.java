package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;
public interface CartMapper {
	//���빺�ﳵ
	public void insertCart(Cart cart);
	//��ѯ�û��Ĺ��ﳵ��Ʒ
	public List<CartVo> selectGoodsByUid(Integer uid);
	//����ɾ�����ﳵ�����Ʒ
	public void deleteByIds(Integer[] ids);
	//ɾ�����ﳵ�����Ʒ
	public void deleteById(Integer id);
	//�޸Ĺ��ﳵ��Ʒ����
	public void updateNumById(@Param("id")Integer id,@Param("num")Integer num);
}
