package simple_sort;


/** 
 *@author liujun
 *@date�� 2018-7-19 ����01:16:13
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class SimpleSortTest {

	public static void main(String[] args) {
		
		//�������ݣ����������123456789
		int [] sort_num = {8,2,4,6,5,7,9,1,3};
		int [] sort_num1 = {1,1,2,2,2,2,5,5,5,5,2,2,2};
		
		System.out.print("ԭʼ���ݣ�");
		for (int i = 0; i < sort_num.length; i++) {
			System.out.print(sort_num[i]+" ");
		}
		System.out.println();
		System.out.print("�����    ��");
		
		//����ð������
		//Bubble_sort b = new Bubble_sort();
		//sort_num = b.Bubble_sort(sort_num);
		
		//ѡ������
		//Selection_sort sel = new Selection_sort();
		//sort_num = sel.Selection_sort(sort_num);
		
		//�����������
		//Insertion_sort ins = new Insertion_sort();
		//sort_num = ins.Insertion_sort(sort_num);
		
		//������
		HeapSort hp = new HeapSort();
		hp.heapSort(sort_num);
		
		//�������
		for (int i = 0; i < sort_num.length; i++) {
			System.out.print(sort_num[i]+" ");
		}
	}
}
