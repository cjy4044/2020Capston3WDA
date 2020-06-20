import React from 'react';
import ReactDOM from 'react-dom';
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
import jQuery from "jquery";
import './css/order.css'
import OrderItem from './orderItem.jsx'

window.$ = window.jQuery = jQuery;



class Order extends React.Component {

    constructor(props){

        super(props)
        this.state = {data:[]}
    }

    async componentDidMount(){
        this.getPrdList();
        
    }
    async getPrdList(){
        
        let {data} = await axios.get(window.location.href.replace('?',"/axios?"));
        console.log(data);
        this.setState({data})
        this.setSumPrice();
    }
    setSumPrice(){
        var sumTag = $('#sumPrice')
        var price = 0;

        this.state.data.map((prd)=>{
            price += (prd.price + prd.oPrice)*prd.count;

        });
        sumTag.text(price+" 원")
    }
    buy(e){
        // e.preventDefault();
        alert("상품을 구매하시겠습니까?");
    }
    render() {
        console.log(this.state.data)
        return(
            <div>
                <form  action="/shop/order" method="post">
                    <input type="hidden" name="_csrf" value={document.cookie.split("=")[1]}/>
                    <div className="grid">
                        <div>
                            <div>
                                <div>구매상품</div>
                                <div>
                                    <OrderItem data={this.state.data}/>
                                </div>
                            </div>
                            <div>
                                <div>수취자 정보</div>
                                <div>주소</div>
                                <input type="text" name="addr" placeholder="도로명주소" required/>
                                <input type="text" name="addr2" placeholder="상세주소" required/>
                                <div>받는분 성함</div>
                                <input type="text" name="receiver" required/>
                                <div>연락처</div>
                                <input type="text" name="phone" required/>
                            </div>
                        </div>
                        <div>
                            <div>
                                <div><h3>총 금액</h3></div>
                                <div id="sumPrice">---원</div>
                                <div><h3>이용약관</h3></div>
                                <div>반품불가</div>
                                <div><input type="checkbox" required/></div>
                            </div>
                            <div>
                                <input type="submit" onSubmit={this.buy.bind(this)} value="구매"/><a href="/shop/index">취소</a>
                            </div>
                        </div>
                    </div>
                </form> 
            </div>
        )
    }
}

ReactDOM.render(<Order/>,document.getElementById('order'));

