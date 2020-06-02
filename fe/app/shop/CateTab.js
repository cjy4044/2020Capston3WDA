import React from 'react';
import Item2 from './Item2';
export default class Cate_tab extends React.Component {
    render() {
        return (
            <div className="category-tab">
                <div className="col-sm-12">
                    <ul className="nav nav-tabs">
                        <li className="active"><a href="#tshirt" data-toggle="tab">액세서리</a></li>
                        <li><a href="#blazers" data-toggle="tab">의류</a></li>
                        <li><a href="#sunglass" data-toggle="tab">생활용품</a></li>
                        <li><a href="#kids" data-toggle="tab">패션소품</a></li>
                        <li><a href="#poloshirt" data-toggle="tab">테피스트리</a></li>
                        <li><a href="#poloshirt" data-toggle="tab">그 외 소품</a></li>
                    </ul>
                </div>
                <div className="tab-content">
                    <div className="tab-pane fade active in" id="tshirt" >
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                    </div>

                    <div className="tab-pane fade" id="blazers" >
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                    </div>

                    <div className="tab-pane fade" id="sunglass" >
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                    </div>

                    <div className="tab-pane fade" id="kids" >
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                    </div>

                    <div className="tab-pane fade" id="poloshirt" >
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                        <Item2></Item2>
                    </div>
                </div>
            </div>
        )
    }
}