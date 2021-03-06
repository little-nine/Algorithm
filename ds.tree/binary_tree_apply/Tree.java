package binary_tree_apply;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
 *@author liujun
 *@date： 2018-7-21 下午01:13:08
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:树、二叉树、先序遍历赋值二叉树、
 *中序遍历赋值二叉树，后序遍历赋值二叉树
 *其中二叉树包含：二叉树的数据结构、二叉树的三种遍历赋值、二叉树的层次遍历、二叉树的按行打印	
 *@version 1.0
 */
public class Tree {

	public static void main(String[] args) {
		binary_tree root = new binary_tree();
		int [] tree_num ={1,5,7,-1,-1,-1,8,6,3,-1,-1,2,-1,-1,9,-1,-1};

		//先序构建二叉树
		root = root.create_preOrder(root, tree_num, 0);
		System.out.println("层次遍历");
		root.levelTraverse(root);
		System.out.println();
		
		System.out.println("二叉树反转");
		二叉树镜像 er = new 二叉树镜像();
		root = er.Mirro(root);
		
		System.out.println("按行遍历");
		root.printTreebyLine(root);
		System.out.println("============");
		
		//二叉树中和为某一值的路径_递归
		二叉树中和为某一值的路径_递归  r = new 二叉树中和为某一值的路径_递归();
		ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();
		all_list = r.FindPath(root, 60);
		int i = 0;
		while (i < all_list.size()) {
			ArrayList<Integer> route_list = new ArrayList<Integer>();
			route_list = all_list.get(i);
			for (int j = 0; j < route_list.size(); j++) {
				System.out.print(route_list.get(j) + " ");
			}
			System.out.println();
			i++;
		}
		
		//二叉树中最大子路径和
		二叉树中最大子路径和 he = new 二叉树中最大子路径和();
		List<Integer> list = he.maxValue(root);
		int max = 0;
		for (int j = 0; j < list.size(); j++) {
			max += list.get(j);
		}
		System.out.println(max);;
	}
}

//二叉树的数据结构
class binary_tree{
	
	binary_tree left;   //左孩子
	binary_tree right;  //右孩子
	int value = 0;      //默认二叉树的值为0
	public static int count = 0;//定义一个全局静态计数变量
	
	public binary_tree(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public binary_tree() {
		// TODO Auto-generated constructor stub
	}

	//二叉树的三种遍历赋值
	//将数组先序遍历赋值二叉树,约定-1是空指针
	public binary_tree create_preOrder(binary_tree root, int [] tree_num ,int i){
		
		if(i < tree_num.length){
			if(tree_num[i] == -1){
				root = null;
			}else{
				//new root's lchild and rchild
				binary_tree lchild = new binary_tree();
				binary_tree rchild = new binary_tree();
				//preOrder
				root.value = tree_num[i];
				//不用++count，构造的时候或出错
				root.left = create_preOrder(lchild, tree_num, ++count);
				root.right = create_preOrder(rchild, tree_num, ++count);
			}
		}
		
		return root;
	}
	
	//将数组中序遍历赋值二叉树
	public binary_tree create_inOrder(binary_tree root){
		
		return root;
	}
	
	//将数组后序遍历赋值二叉树
	public binary_tree create_postOrder(binary_tree root){
	
	    return root;
    }

	//清零操作
	public void clear(){
		count = 0;
	}
	//二叉树的层次遍历,使用栈来辅助实现
	public void levelTraverse(binary_tree root){
		
		// Queue is just an interface, LinkedList is Realization
		Queue<binary_tree> queue = new LinkedList<binary_tree>();
		queue.offer(root);
		while(!queue.isEmpty()){
			binary_tree note = queue.poll();
			System.out.print(note.value + " ");
			if(note.left != null){
				levelTraverse(note.left);
			}
			if(note.right != null){
				levelTraverse(note.right);
			}
		}
	}
	
	// 二叉树的按行打印
	public void printTreebyLine(binary_tree root) {
		if(root == null){
			return;
		}
		//设置换行的标志指针：pre,next
		binary_tree pre = null;
		binary_tree next = null;
		//树进队列
		Queue<binary_tree> queue = new LinkedList<binary_tree>();
		queue.offer(root);
		next = pre = root;
		//指针移动操作
		while (!queue.isEmpty()) {
			binary_tree note = queue.poll();
			System.out.print(note.value + " ");
			if(note.left != null){
				pre = note.left;
				queue.add(note.left);
			}
			if(note.right != null){
				pre = note.right;
				queue.add(note.right);
			}
			//换行
			if (note.value == next.value) {
				next = pre;
				System.out.println();
			}
		}
	}
}