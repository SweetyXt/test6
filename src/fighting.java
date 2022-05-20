;import java.util.Scanner;
import java.util.HashSet;
public class fighting
{
    public static void main(String[] args)
    {
        System.out.println("请输入英文句子：");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuffer str1=new StringBuffer();//StringBuffer为可变字符串
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'||str.charAt(i)>='A'&&str.charAt(i)<='Z')//判断英文单词，若连续若干字母即为一个英文单词，将其作为单词组成部分放入StringBuffer中
            {
                str1.append(str.charAt(i));
            }
            else//将单词用逗号隔开
            {
                str1.append(",");
            }
        }
        String[] str2=str1.toString().split(",");//先利用toString将StringBuffer转换为String类对象，再利用split方法按逗号将其分开存入数组
        System.out.println("该句子一共有"+str2.length+"个单词");
        System.out.println("-----------------------------");
        for(int n=0;n<str2.length;n++)//遍历输出句子单词
        {
            System.out.print(str2[n]+" ");
        }
        System.out.println();
        System.out.println("-----------------------------");

        HashSet<String> repeatedwords=new HashSet<String>();//用来存放重复单词集合
        HashSet<String> unrepeatedwords=new HashSet<String>();//用来存放不重复单词集合
        for(String token:str2)//增强型for循环，语法格式为for（集合内储存类型 变量名 ： 集合变量名），定义一个String型变量token, 每次从数组str2里取一个元素付给变量token,直到把str2里的所有元素都处理完.
        {
            if(!unrepeatedwords.add(token))
                repeatedwords.add(token);//因为Set分支的特点是无序且不可重复，因此通过add方法添加相同的值时，第一次返回为true，后面再加相同元素的话就会返回false，因为元素重复
        }
        System.out.println("该句子不同的单词有"+unrepeatedwords.size()+"个  "+unrepeatedwords);//size()获取集合长度
        System.out.println("-----------------------------");
        System.out.println("该句子重复的单词有"+repeatedwords.size()+"个  "+repeatedwords);

    }
}
