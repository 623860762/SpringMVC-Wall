package testMethod.cms_common;  
  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  

  
/** 
 * ������� 
*/  
public class MultipleTree {  
	
	public String makeTree(List tempList){
		  // �ڵ��б?ɢ�б?������ʱ�洢�ڵ����  
		  Map nodeList = new HashMap();  
		  // ��ڵ�  
		  Node root = null;  
		  // ��ݽ����ڵ��б?����ɢ�б?  
		  for (Iterator it = tempList.iterator(); it.hasNext();) { 
		   HashMap dataRecord = (HashMap) it.next();
		   Node node = new Node();  
		   node.id = (String) dataRecord.get("id");  
		   node.text = (String) dataRecord.get("text"); 
		   node.parentId = (String) dataRecord.get("parentId"); 
		   nodeList.put(node.id, node);  
		  }  
		  // ��������Ķ����  
		  Set entrySet = nodeList.entrySet();  
		  for (Iterator it = entrySet.iterator(); it.hasNext();) {  
		   Node node = (Node) ((Map.Entry) it.next()).getValue();  
		   if (node.parentId.equals("-1")) {  
		    root = node;  
		   } else {  
		    ((Node) nodeList.get(node.parentId)).addChild(node);  
		   }  
		  }
		  // �����������β˵���JSON�ַ�  
		 // System.out.println(root.toString());     
		  // �Զ�������к�������  
		  //root.sortChildren();  
		  // �����������β˵���JSON�ַ�  
		  return "["+root.toString()+"]";
	}
 public static void main(String[] args) {  
	// ��ȡ�����ݽ���б�   
/*	  List dataList = VirtualDataGenerator.getVirtualResult();    
	  System.out.println(new MultipleTree().makeTree(dataList));*/
	 List dataList = VirtualDataGenerator.getVirtualResult();
	  System.out.println(new MultipleTree().makeTree(dataList));
   
 }  
     
}  
