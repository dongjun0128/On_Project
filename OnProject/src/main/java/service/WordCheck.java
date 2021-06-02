package service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WordCheck {

    // tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public boolean check(String search) {
		int page = 1;	// 페이지 초기값
		boolean result = false;
		try{
			//while(true){
				// parsing할 url 지정(API 키 포함해서)
				//String newSearch = new String(search.getBytes("utf-8"));
				String url = "https://opendict.korean.go.kr/api/search?certkey_no=2717&key=5E8E8C2865A57B03822094ED08DA3F4F&target_type=search&advanced=y&q="+search+"&sort=dict";
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				Element root = doc.getDocumentElement();
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				//자식 노드
				/*
				NodeList childeren = root.getChildNodes();
				for(int i=0;i<childeren.getLength();i++)
				{
					Node node = childeren.item(i);
					System.out.println(node.getNodeName());
				}
				*/
				//System.out.println(childeren.getLength());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				
				//존재하면 true 리턴
				if(nList.getLength()>0)
					return true;
				else if(nList.getLength()==0)
					return false;
				/*
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						System.out.println("######################");
						//System.out.println(eElement.getTextContent());
						System.out.println("단어 : "+ getTagValue("word",eElement));
						System.out.println("번호  : " + getTagValue("sense_no", eElement));
						System.out.println("설명  : " + getTagValue("definition", eElement));
						System.out.println("위치 : " + getTagValue("pos", eElement));
						System.out.println("링크 : " + getTagValue("link", eElement));
						System.out.println("타입  : " + getTagValue("type", eElement));
					}	// for end
				}	// if end
				
				page += 1;
				//System.out.println("page number : "+page);
				if(page > 12){	
					break;
				}
				*/
			//}	// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		return result;
	}	// main end
}	// class end

