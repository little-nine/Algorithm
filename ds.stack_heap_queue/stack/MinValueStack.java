package stack;

import java.util.Stack;

/** 
 *@author liujun
 *@date： 2018-8-25 下午03:47:41
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:定义一个栈，除了常规操作，还可以随时查找栈中最小值。
 *@version 1.0
 */
public class MinValueStack extends Stack<Integer>{

	private static final long serialVersionUID = 1224463164541339165L;
	
	Stack<Integer> stack = new Stack<Integer>();
	MinValueStack ministack = new MinValueStack();
	
	public MinValueStack() {
		// TODO Auto-generated constructor stub
	}
	
	private synchronized Integer minValue() {
		// TODO Auto-generated method stub
		return ministack.peek();
	}
	
	@Override
	public Integer push(Integer item) {
		// TODO Auto-generated method stub
		if (item < ministack.peek()) {
			return super.push(item);
		}else {
			return super.push(ministack.peek());
		}
	}
	
	@Override
	public synchronized Integer pop() {
		// TODO Auto-generated method stub
		ministack.pop();
		return super.pop();
	}
	
	//主方法测试
	public static void main(String[] args) {
		MinValueStack ms = new MinValueStack();
		int[] array = {9,5,4,8,1,2,6};
		for (int i = 0; i < array.length; i++) {
			ms.push(array[i]);
		}
		System.out.println(ms.peek());
	}
}
