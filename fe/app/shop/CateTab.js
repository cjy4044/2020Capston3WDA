import React from 'react';
import Item2 from './Item2';
export default class Cate_tab extends React.Component {
    constructor(props){
        super(props)

    }


    render() {
        console.log(this.props)
        return (
            <div className="category-tab">
                <div className="col-sm-12">
                    <ul className="nav nav-tabs">
                        <li className="active"><a href="#accessory" data-toggle="tab">액세서리</a></li>
                        <li><a href="#clothing" data-toggle="tab">의류</a></li>
                        <li><a href="#dailySup" data-toggle="tab">생활용품</a></li>
                        <li><a href="#fashion" data-toggle="tab">패션소품</a></li>
                        <li><a href="#tapestry" data-toggle="tab">테피스트리</a></li>
                        <li><a href="#etc" data-toggle="tab">그 외 소품</a></li>
                    </ul>
                </div>
                <div className="tab-content">
                    <div className="tab-pane fade active in" id="accessory" >
                        <Item2 data={this.props.data?this.props.data.accessory:[]}></Item2>
                    </div>

                    <div className="tab-pane fade" id="clothing" >
                        <Item2 data={this.props.data?this.props.data.clothing:[]}></Item2>
                    </div>
                    <div className="tab-pane fade" id="dailySup" >
                        <Item2 data={this.props.data?this.props.data.dailySup:[]}></Item2>
                    </div>
                    <div className="tab-pane fade" id="fashion" >
                        <Item2 data={this.props.data?this.props.data.fashion:[]}></Item2>
                    </div>

                    <div className="tab-pane fade" id="tapestry" >
                        <Item2 data={this.props.data?this.props.data.tapestry:[]}></Item2>
                    </div>

                    <div className="tab-pane fade" id="etc" >
                        <Item2 data={this.props.data?this.props.data.etc:[]}></Item2>
                    </div>
                </div>
            </div>
        )
    }
}