import React from 'react';
export default class Item extends React.Component {
    render() {
        console.log(this.props.data);
        return this.props.data.map((prd, index) => {
            return (
                <div className="col-sm-4">
                    <div className="product-image-wrapper">
                        <div className="single-products">
                            <div className="productinfo text-center">
                                <img src="images/home/product1.jpg" alt="" />
                                <h2>{prd.price}원</h2>
                                <p>{prd.name}</p>
                                <a href="#" className="btn btn-default add-to-cart"><i className="fa fa-shopping-cart"></i>Add to cart</a>
                            </div>
                            <div className="product-overlay">
                                <div className="overlay-content">
                                    <h2></h2>
                                    <p></p>
                                    <a href="#" className="btn btn-default add-to-cart"><i className="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                            </div>
                        </div>
                        <div className="choose">
                            <ul className="nav nav-pills nav-justified">
                                <li><a href="#"><i className="fa fa-plus-square"></i>Add to wishlist</a></li>
                                <li><a href="#"><i className="fa fa-plus-square"></i>Add to compare</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            )
        })

    }
}