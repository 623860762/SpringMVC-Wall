package testMethod.cms_common; 
/** 
* �ڵ��� 
*/  
class Node {  
 /** 
  * �ڵ��� 
  */  
 public String id;  
 /** 
  * �ڵ����� 
  */  
 public String text;  
 /** 
  * ���ڵ��� 
  */  
 public String parentId;  
 /** 
  * ���ӽڵ��б� 
  */
 public String state;
 
 private Children children = new Children();  
   
 // �������ƴ��JSON�ַ�  
 public String toString() {    
  String result = "{"  
   + "\"id\" : \"" + id + "\"" 
   + ", \"text\" : \"" + text + "\"";
    
  if (children != null && children.getSize() != 0) {  
	  result += ", \"state\":\"closed\",\"children\" : " + children.toString();  
  } 
      
  return result + "}";  
 }  
   
 // �ֵܽڵ��������  
 public void sortChildren() {  
  if (children != null && children.getSize() != 0) {  
   children.sortChildren();  
  }  
 }  
   
 // ��Ӻ��ӽڵ�  
 public void addChild(Node node) {  
  this.children.addChild(node);  
 }  
}  

