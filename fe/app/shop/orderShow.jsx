import React from 'react';
import ReactDOM from 'react-dom';
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;



class OrderShow extends React.Component {
    constructor(props){
        super(props)
        this.state = {prd:{}}
        this.url;
        
    }


    async componentDidMount(){    
        var listId = $("#listId").val()
        this.url = '/shop/orderShow/'+listId+'/axios'
        this.getItem();
        
    }
    async getItem(){
        let {data} = await axios.get(this.url);
        console.log(data);
        this.setState({prd : data.orderList[0]})
    }
    render() {
        var prd = this.state.prd;
        if(prd.img){
            return (
                <div>
                    <div>주문 상세</div>
                    <a href={"/shop/product/"+prd.productId}>
                        <img src={"/uploads/"+prd.img}/>
                        <div>상품명: {prd.name}</div>
                    </a>
                    <div>옵션명: {prd.oTItle}</div>
                    <div>개수: {prd.count}</div>
                    <div>가격: {prd.itemPrice}</div>
                    <div>수취자: {prd.receiver}</div>
                    <div>수취자 연락처: {prd.phone}</div>
                    <div>도로명 주소:{prd.addr}</div>
                    <div>상세 주소:{prd.addr2}</div>
                    <div>주문상태: {
                    prd.invoice?prd.invoice==0?
                    '확인전':prd.invoice==1?
                    '확인': prd.invoice==2?
                    '배송중:':prd.invoice==3?
                    '배송완료':prd.invoice==4?
                    '확인바람':'확인바람':'확인전'}</div>
                    <div>운송장 번호: {prd.state?prd.state:'등록되지 않음.'}</div>
                </div>
                
            )
        
        }else{
            return <div>주문 상품 정보가 없습니다.</div>
        }
    }
}

ReactDOM.render(<OrderShow/>,document.getElementById('orderShow'));

