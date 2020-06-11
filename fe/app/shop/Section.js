import React from 'react';
import LeftSidebar from './LeftSidebar';
import NewItem from './NewItem';
import CateTab from './CateTab';
import Item2 from './Item2';
export default class Section extends React.Component {
    
    
    render() {
        console.log(this.props.data);
        return (
            <section>
                <div className="container">
                    <div className="row">
                        <div className="col-sm-3"> {/* 왼쪽 카테고리, 프로그램 별... */} 
                            <LeftSidebar></LeftSidebar>
                        </div>
                        
                        <div className="col-sm-9 padding-right"> {/* 오른쪽 신상품... 상품목록 */}
                            <NewItem data={this.props.data}></NewItem>
                            <CateTab></CateTab>

                            <div className="recommended_items">
                                <h2 className="title text-center">recommended items</h2>

                                <div id="recommended-item-carousel" className="carousel slide" data-ride="carousel">
                                    <div className="carousel-inner">
                                        <div className="item active">
                                            <Item2></Item2>
                                            <Item2></Item2>
                                            <Item2></Item2>
                                            <Item2></Item2>
                                        </div>
                                        <div className="item">
                                            <Item2></Item2>
                                            <Item2></Item2>
                                            <Item2></Item2>
                                            <Item2></Item2>
                                        </div>
                                    </div>
                                    <a className="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                                        <i className="fa fa-angle-left"></i>
                                    </a>
                                    <a className="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                                        <i className="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        )
    }
}