package com.ch.until.power;

import com.ch.entity.Power;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * @Description: 权限菜单
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public class PowerUntil {
	
	public static List<Power> getPowerData(List<Power> powers, String url){
		List<Power> resPower = new ArrayList<Power>();
		int size = powers.size();
		for(int i=0;i<size;i++){
			int pid = powers.get(i).getPid();
			String furl = powers.get(i).getUrl();
			if(url.equals(furl)){
				powers.get(i).setActive("start active");
			}
			List<Power> addPower = new ArrayList<Power>();
			for(int j=0;j<size;j++){
				if(i==j)continue;
				if(powers.get(j).getPid()==0)continue;
				String chUrl = powers.get(j).getUrl();
				if(powers.get(j).getPid().intValue()==powers.get(i).getId().intValue()){
					if(url.equals(chUrl)){
						powers.get(i).setActive("start active");
						powers.get(j).setActive("active");
						powers.get(i).setContent("open");
					}
					addPower.add(powers.get(j));
				}
			}
			powers.get(i).setPowers(addPower);
			if(pid==0){
				resPower.add(powers.get(i));
			}
		}
		return resPower;
	}
	public static List<Power> getPowerfp(List<Power> havePower,List<Power> power){
		int hsize = havePower.size();
		int size = power.size();
		for(int i=0;i<size;i++){
			for(int j=0;j<hsize;j++){
				if(havePower.get(j).getId().intValue()==power.get(i).getId().intValue()){
					power.get(i).setIsLay(1);
				}
			}
		}
		List<Power> resPower = new ArrayList<Power>();
		for(int i=0;i<size;i++){
			if(power.get(i).getPid()!=0)continue;
			List<Power> pws = new ArrayList<Power>();
			for(int j=0;j<size;j++){
				if(power.get(j).getPid()==0)continue;
				if(power.get(j).getPid().intValue()==power.get(i).getId().intValue()){
					pws.add(power.get(j));
				}
			}
			power.get(i).setPowers(pws);
			resPower.add(power.get(i));
		}
		return resPower;
	}
}
