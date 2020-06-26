import React from 'react';
import '../smart.css';

export default class BagItem extends React.Component {
    render() {
        console.log(this.props.data);
        return this.props.data? this.props.data.map((prd, index) => {
            return (
                <div className="bagItem" key={index}>
                    <div className="bagCheckBox">
                        <input type="checkbox"  onClick={this.props.check.bind(this,this.props.this,index)}/>
                    </div>
                    <a href={"/shop/product/"+prd.productId}>
                        <img className="smartImg" src={"/uploads/"+prd.img}></img>
                        <div>상품명: {prd.name}</div>
                    </a>
                    <div>옵션명: {prd.oTitle}</div>
                    <div>{prd.quantity}개</div>
                    <div>{(prd.price + prd.oPrice)*prd.quantity}원</div>
                    <input type="button" onClick={this.props.event.bind(this,prd.id)} value="삭제하기"/>
                </div>
            )
        })
        :
        (
            <div>장바구니가 비었습니다.</div>
        )

    }
}