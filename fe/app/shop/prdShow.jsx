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
        this.state ={sub:[], info:[],prd:{}, option:[], color:[],size:[], manager:{}};
        this.colorTag;
        
    }
    async componentDidMount(){    
        let {data} = await axios.get('/shop/product/axios/'+param);
        //0: 상품정보  1: 상품 이미지   2: 옵션 정보    3: 색상 리스트   4: 사이즈 리스트 

        var sub = [];
        var info = []; // 설명이미지
        data[1].map((img,index)=>{
            
            if(img.imageState == 1)
                sub.push(img);
            else if(img.imageState ==2)
                info.push(img)
            
        });
        // console.log("sub:"+sub);

        this.setState({sub:sub, prd:data[0], option:data[2], color:data[3], size:data[4], manager:data[5], info:info})

        console.log(data);
        this.setOption();
        this.createDefaultImg();
    }
    setOption(){
        var div = $('#optionSelect')
        var select = $(document.createElement("select"));

        select.attr("id","selectOption")
        select.attr("name","prdOption");
        select.on("change",this.sumPriceSet.bind(this))

        var option = $(document.createElement("option"));
        
        for(var i=0; i<this.state.option.length;i++){
            var option = $(document.createElement("option"));
            option.val(this.state.option[i].optionId)
            if(i==0)
                option.text(this.state.option[i].oTitle) // 기본옵션일 경우.
            else 
                option.text(this.state.option[i].oTitle+"\t\t\t\t +"+this.state.option[i].oPrice+"원") //추가옵션일 경우.
            option.attr("addPrice",this.state.option[i].oPrice);
            select.append(option);
        }
        
        div.append(select);
    }

    sumPriceSet(){
        var sum = this.state.prd.price + parseInt($('#selectOption option:selected').attr("addPrice"))
        var sum = sum * $("#quantity").val();
        $("#sumPrice").html(sum+"원")
        
    }

    createDefaultImg(){
        var div = $(".sub")
        console.log(this.state.sub)
        this.state.sub.map((img,index)=>{
            var imgTag = $(document.createElement("img"));
            console.log(img)
            imgTag.attr("src",'/uploads/'+img.productImage)
            imgTag.attr("class","subImg");
            div.append(imgTag);
        })
        
    }
    async addMybag(){// 장바구니 추가.

        console.log($('#quantity').val());
        if($('#quantity').val() == null || $('#quantity').val() <= 0)
            return alert("수량을 입력해주세요.");

        if(!confirm("장바구니에 추가하시겠습니까?"))
            return;
        
        let {data} = await axios.post("/shop/"+this.state.prd.productId+"/mybag",{

                optionId : $('#selectOption').val(),
                quantity : $('#quantity').val()

        });
        
        if(data.success){
            if(confirm(data.success+"\n장바구니로 이동하시겠습니까?")){
                location.href = "/shop/mybag"
            }
        }else{
            alert("장바구니 추가에 실패했습니다.");
        }
        
        
    }
    order(){
        
        if($('#quantity').val() == null || $('#quantity').val() <= 0)
            return alert("수량을 입력해주세요.");

        if(!confirm("해당 상품을 구매하시겠습니까?"))
            return

        
        location.href =
        "/shop/order?productId="+this.state.prd.productId+"&optionId="+$('#selectOption').val()+"&quantity="+$('#quantity').val()

    }
    render() {
        var prd = this.state.prd;
        
        return (
            <div className="topDiv">
                <div><a href="/shop/mybag">장바구니</a></div>
                <div className="grid">
                    <div className="imgs" >
                        <div className="sum">
                        <img src={"/uploads/"+prd.img} ></img>
                        </div>
                        <div className="sub">

                        </div>
                    </div>
                    <div className="itemInfo">
                        <div>상품명:{prd.name}</div>
                        <div>제품 설명:{prd.content}</div>
                        <div>재고: {prd.stock} 개</div>
                        <div>가격: {prd.price} 원</div>
                        <div>옵션</div>
                        <div id="optionSelect"></div>
                        <div>수량</div>
                        <div><input type="number" id="quantity" min="1" max="9999" defaultValue="1" onChange={this.sumPriceSet.bind(this)}/></div>
                        <div>총 가격</div>
                        <h3 id="sumPrice">{prd.price}원</h3>
                        
                        <input type="button" value="장바구니 추가" onClick={this.addMybag.bind(this)}/>
                        <input type="button" value="구매" onClick={this.order.bind(this)}/>
                    </div>
                </div>
                <div className="itemDetails">
                    <div>
                        {/* 상세 설명 부분 */}
                        <div>상세 세부 설명 ....</div>
                        <div>
                            <div id="infoImage">
                            {
                                this.state.info.map((img, index)=>{
                                    console.log(img)
                                    return <img className="infoImage" key={img.no}src={"/uploads/"+img.productImage}></img>
                                })
                            }

                            </div>
                            <div>{prd.p_DETAIL}</div>
                        </div>
                        
                    </div>
                    <div>판매자: {this.state.manager.name}</div>
                    <div>판매자 연락처: {this.state.manager.phone?this.state.manager.phone:"X"}</div>
                </div>
            </div>
            
        )
    }
}

ReactDOM.render(<PrdShow/>,document.getElementById('prdShow'));

