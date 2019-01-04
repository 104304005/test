package HW6;

import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
	public WebNode root;
	
	public WebTree(WebPage rootPage) {
		this.root = new WebNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Keyword>keywords) throws IOException{
		setPostOrderScore(root,keywords);
	}
	
	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword>keywords) throws IOException{
		for(WebNode child : startNode.children) {
			setPostOrderScore(child,keywords);
		}
		
		startNode.setNodeScore(keywords);
	}
	
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(WebNode startNode) {
		int place = startNode.getDepth()-1;
		String all="";
		for(int i=0;i<place;i++) {
			all+="\t";	
		}
		System.out.print(all);
		System.out.print("(");
		if(startNode.children.size()!=0) {
			System.out.println(startNode.webPage.name+","+startNode.nodeScore);
			for(WebNode child : startNode.children) {
				printTree(child);
			}
			System.out.println(all+")");
		}else {
			System.out.print(startNode.webPage.name+","+startNode.nodeScore);
			System.out.println(")");
		}
	}
}
