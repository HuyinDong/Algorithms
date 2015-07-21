package com.alg.basic;

class TreeNode{
	private int key;
	private TreeNode prnt;
	private TreeNode lChd;
	private TreeNode rChd;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public TreeNode getPrnt() {
		return prnt;
	}
	public void setPrnt(TreeNode prnt) {
		this.prnt = prnt;
	}
	public TreeNode getlChd() {
		return lChd;
	}
	public void setlChd(TreeNode lChd) {
		this.lChd = lChd;
	}
	public TreeNode getrChd() {
		return rChd;
	}
	public void setrChd(TreeNode rChd) {
		this.rChd = rChd;
	}
	public TreeNode(int key) {
		super();
		this.key = key;
	}
	@Override
	public String toString() {
		return "TreeNode [key=" + key + "]";
	}
	
}
public class BinaryTree {
	public static void main(String[] args){
		int[] arr = new int[]{5,3,6,2,8,4,7,1};
		BinaryTree bt = new BinaryTree(arr);
		System.out.print("inorder: ");
		bt.inorder_Tree_Walk(bt.getRoot());
		System.out.println();
		System.out.print("preorder: ");
		bt.preorder_Tree_Walk(bt.getRoot());
		System.out.println();
		System.out.print("postorder: ");
		bt.postorder_Tree_Walk(bt.getRoot());
	}
	
	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	private TreeNode root;
	public BinaryTree(int[] arr){
	  for(int i : arr){
		  this.addTreeNode(i);
	  }
	}
	public void addTreeNode(int key){
		TreeNode tn = new TreeNode(key);
		if(root == null){
			root = tn;
		}else{
			this.searchPos(root,tn);
		}
	}
	public void searchPos(TreeNode p, TreeNode tn){
		if(tn.getKey() < p.getKey() ){
			if(p.getlChd() == null){
				p.setlChd(tn);
				tn.setPrnt(p);
			}else{
				p = p.getlChd();
				this.searchPos(p, tn);
			}
		}else{
			if(p.getrChd() == null){
				p.setrChd(tn);
				tn.setPrnt(p);
			}else{
				p = p.getrChd();
				this.searchPos(p, tn);
			}
		}
	}
	public void inorder_Tree_Walk(TreeNode tn){
		if(tn != null){
			this.inorder_Tree_Walk(tn.getlChd());
			System.out.print(tn.getKey()+",");
			this.inorder_Tree_Walk(tn.getrChd());	
		}
	
	}
	public void preorder_Tree_Walk(TreeNode tn){
		if(tn != null){
			System.out.print(tn.getKey()+",");
			this.preorder_Tree_Walk(tn.getlChd());
			this.preorder_Tree_Walk(tn.getrChd());
		}
	}
	public void postorder_Tree_Walk(TreeNode tn){
		if(tn != null){
			this.postorder_Tree_Walk(tn.getlChd());
			this.postorder_Tree_Walk(tn.getrChd());
			System.out.print(tn.getKey()+",");
		}
	}
}
