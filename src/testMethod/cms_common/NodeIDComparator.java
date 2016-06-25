package testMethod.cms_common;  
import java.util.Comparator;

/** 
 * �ڵ�Ƚ��� 
 */  
class NodeIDComparator implements Comparator {  
 // ���սڵ��űȽ�  
 public int compare(Object o1, Object o2) {  
  int j1 = Integer.parseInt(((Node)o1).id);  
     int j2 = Integer.parseInt(((Node)o2).id);  
     return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));  
 }   
}  
