package com.dai;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    class ListNode {
        int value;
        ListNode next;
        ListNode pre;
        ListNode(int value) {
            this.value = value;
        }
    }
    ListNode head = null;
    ListNode cur = null;
    ListNode pre = null;
    int count = 0;
    public void push(int target) {
        if (this.size() == 0){
            head = new ListNode(target);
            cur = head;
            count++;
            return;
        }
        ListNode tmp = new ListNode(target);
        cur.next = tmp;
        tmp.pre = cur;
        pre = cur;
        cur = tmp;
        count++;
    }
    public int top() {
        if (head == null){
            return -1;
        }
        return head.value;
    }
    public int pop() {
        if (head == null){
            return -1;
        }
        ListNode tmp = head.next;
        head.next = null;
        if (tmp != null ) tmp.pre = null;
        head = tmp;
        count--;
        return 0;
    }
    public int size() {
        return count;
    }
    public void clear() {
        head = null;
        cur = null;
        pre = null;
        count = 0;
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner reader = new Scanner(System.in);
        int m = Integer.parseInt(reader.nextLine());
        for(int i = 0; i < m ; i++) {
            int n = Integer.parseInt(reader.nextLine());
            for (int j = 0; j < n; j++) {
                String s = reader.nextLine().trim();
                if (s.startsWith("PUSH")) {
                    String ss = s.split(" ")[1];
                    main.push(Integer.parseInt(ss));
                    continue;
                }

                switch (s) {
                    case "TOP" : System.out.println(main.top()+"ccc");break;
                    case "SIZE" : System.out.println(main.size()+"aaa");break;
                    case "POP" : {
                        if (main.pop() == -1) {
                            System.out.println("-1");
                        }
                    }
                    break;
                    case "CLEAR" : main.clear();
                }
            }
            main.clear();

        }


    }

}
