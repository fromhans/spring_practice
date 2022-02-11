package group.core.discount;

import group.core.member.Grade;
import group.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // given
        Member member = new Member(1L, "testA", Grade.VIP);
        int price = 100;

        // when
        int discountPrice = rateDiscountPolicy.discount(member, price);

        // then
        Assertions.assertThat(discountPrice).isEqualTo(10);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // given
        Member member = new Member(1L, "testA", Grade.BASIC);
        int price = 100;

        // when
        int discountPrice = rateDiscountPolicy.discount(member, price);

        // then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }
}