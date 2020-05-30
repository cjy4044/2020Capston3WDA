import React from 'react';

class Slider extends React.Component {
    render() {
        return (
            <div className="item active">
                <div className="col-sm-6">
                    <h1>RIRO Goods Shop</h1>
                    <h2>오픈 이벤트</h2>
                    <p>10만원 이상 결제시 10% 할인</p>
                    <p>사진 리뷰 작성시 500P 적립</p>
                    <button type="button" className="btn btn-default get">쿠폰받기</button>
                </div>
                <div className="col-sm-6">
                    <img src="images/home/girl1.jpg" className="girl img-responsive" alt="" />
                    <img src="images/home/pricing.png" className="pricing" alt="" />
                </div>
            </div>

            <div class="item">
                <div class="col-sm-6">
                    <h1><span>E</span>-SHOPPER</h1>
                    <h2>100% Responsive Design</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                    <button type="button" class="btn btn-default get">Get it now</button>
                </div>
                <div class="col-sm-6">
                    <img src="images/home/girl2.jpg" class="girl img-responsive" alt="" />
                    <img src="images/home/pricing.png" class="pricing" alt="" />
                </div>
            </div>

            <div class="item">
                <div class="col-sm-6">
                    <h1><span>E</span>-SHOPPER</h1>
                    <h2>Free Ecommerce Template</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                    <button type="button" class="btn btn-default get">Get it now</button>
                </div>
                <div class="col-sm-6">
                    <img src="images/home/girl3.jpg" class="girl img-responsive" alt="" />
                    <img src="images/home/pricing.png" class="pricing" alt="" />
                </div>
            </div>
        )
    }
}


export default Slider;