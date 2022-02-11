package group.core;

import group.core.member.Grade;
import group.core.member.Member;
import group.core.member.MemberService;
import group.core.member.MemberServiceImpl;
import group.core.order.Order;
import group.core.order.OrderService;
import group.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService= new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+order);
        System.out.println("calculatePrice = "+order.calculatePrice());
    }
}
