import React from 'react';

import '../smart.css';

export default class OrderListItem extends React.Component {
    render() {
        console.log(this.props.data);
        return this.props.data? this.props.data.map((prd, index) => {
            return (
                <div key={index}>
                    <a href={"/shop/orderShow/"+prd.orderListId}>
                        <img className="smartImg" src={"/uploads/"+prd.img}/>
                        <div>상품명: {prd.name}</div>
                    </a>
                    <div>옵션명: {prd.oTitle}</div>
                    <div>가격: {prd.itemPrice}</div>

                </div>
            )
        })
        :
        (
            <div>주문 내역이 없습니다.</div>
        )

    }
}