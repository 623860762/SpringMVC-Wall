package testMethod.cms_common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 
 * ��������Ĳ����� 
 */  
class VirtualDataGenerator {  
 // ��������Ľ���б?ʵ��Ӧ���У������Ӧ�ô���ݿ��в�ѯ��ã�  
 public static List getVirtualResult() {      
  List dataList = new ArrayList();  
    
  HashMap dataRecord1 = new HashMap();  
  dataRecord1.put("id", "-1");  
  dataRecord1.put("text", "�ȷ����н�ŵ�֧��");  
  dataRecord1.put("parentId", "110000");  
    
  HashMap dataRecord2 = new HashMap();  
  dataRecord2.put("id", "112200");  
  dataRecord2.put("text", "�ȷ���������֧��");  
  dataRecord2.put("parentId", "112000");  
    
  HashMap dataRecord3 = new HashMap();  
  dataRecord3.put("id", "112100");  
  dataRecord3.put("text", "�ȷ����й�����֧��");  
  dataRecord3.put("parentId", "112000");  
        
  HashMap dataRecord4 = new HashMap();  
  dataRecord4.put("id", "113000");  
  dataRecord4.put("text", "�ȷ����п�����֧��");  
  dataRecord4.put("parentId", "110000");  
        
  HashMap dataRecord5 = new HashMap();  
  dataRecord5.put("id", "100000");  
  dataRecord5.put("text", "�ȷ���������");  
  dataRecord5.put("parentId", "");  
    
  HashMap dataRecord6 = new HashMap();  
  dataRecord6.put("id", "110000");  
  dataRecord6.put("text", "�ȷ�����");  
  dataRecord6.put("parentId", "100000");  
    
  HashMap dataRecord7 = new HashMap();  
  dataRecord7.put("id", "111000");  
  dataRecord7.put("text", "�ȷ����н���֧��");  
  dataRecord7.put("parentId", "110000");    
      
  dataList.add(dataRecord1);  
  dataList.add(dataRecord2);  
  dataList.add(dataRecord3);  
  dataList.add(dataRecord4);  
  dataList.add(dataRecord5);  
  dataList.add(dataRecord6);  
  dataList.add(dataRecord7);  
    
  return dataList;  
 }   
}  

