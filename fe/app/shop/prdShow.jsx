import React from 'react';
import ReactDOM from 'react-dom';
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;

import './css/show.css'



var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];

class PrdShow extends React.Component {
    constructor(props){
        super(props)
        this.state ={sum:0, sub:[], prd:{}, option:[], color:[],size:[], manager:{}};
        this.colorTag;
        
    }
    async componentDidMount(){    
        let {data} = await axios.get('/shop/product/axios/'+param);
        //0: 상품정보  1: 상품 이미지   2: 옵션 정보    3: 색상 리스트   4: 사이즈 리스트 

        var sum;
        var sub = [];
        data[1].map((img,index)=>{
            if(img.imageState ==0)
                sum = img;
            else(img.imageState ==1)
                sub.push(img);
        });

        this.setState({sum:sum, sub:sub, prd:data[0], option:data[2], color:data[3], size:data[4], manager:data[5]})

        console.log(data);
        this.setOption();
        
    }
    setOption(){
        var div = $('#optionSelect')
        var select = $(document.createElement("select"));

        select.attr("name","prdOption");

        var option = $(document.createElement("option"));
        
        option.val(0)
        option.text("기본")
        select.append(option);
        for(var i=0; i<this.state.option.length;i++){
            var option = $(document.createElement("option"));
            option.val(this.state.option[i].optionId)
            option.text(this.state.option[i].oTitle+"\t\t\t\t +"+this.state.option[i].oPrice+"원")
            select.append(option);
        }
        
        



        div.append(select);
    }

    render() {
        var prd = this.state.prd;
        return (
            <div className="topDiv">
                <div className="grid">
                    <div className="imgs" >
                        <div className="sum">
                        <img src={"/uploads/"+this.state.sum.productImage} style={{width:200, height:200}}></img>
                        </div>
                        <div className="sub">
                            <img src="#" alt="X" style={{width:50, height:50}}></img>
                            <img src="#" alt="X" style={{width:50, height:50}}></img>
                            <img src="#" alt="X" style={{width:50, height:50}}></img>
                        </div>
                    </div>
                    <div className="itemInfo">
                        <div>상품명:{prd.p_NAME}</div>
                        <div>제품 설명:{prd.p_CONTENT}</div>
                        <div>재고: {prd.p_STOCK} 개</div>
                        <div>가격: {prd.p_PRICE} 원</div>
                        <div id="optionSelect"></div>
                        <input type="button" value="장바구니 추가"/><input  type="button" value="구매"/>
                    </div>
                </div>
                <div className="itemDetails">
                    <div>
                        {/* 상세 설명 부분 */}
                        <div>상세 세부 설명 ....</div>
                        <div>{prd.p_DETAIL}</div>
                    </div>
                    <div>판매자: </div>
                    <div>판매자 연락처: </div>
                </div>
            </div>
            
        )
    }
}

ReactDOM.render(<PrdShow/>,document.getElementById('prdShow'));
