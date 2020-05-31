import React from 'react';
export default class LeftSidebar extends React.Component {
    render() {
        return (
            <div className="left-sidebar">
                <h2>카테고리</h2>
                <div className="panel-group category-products" id="accordian">
                    <div className="panel panel-default">
                        <div className="panel-heading">
                            <h4 className="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#1">
                                    <span className="badge pull-right"><i className="fa fa-plus"></i></span>
											악세서리
										</a>
                            </h4>
                        </div>
                        <div id="1" className="panel-collapse collapse">
                            <div className="panel-body">
                                <ul>
                                    <li><a href="#">열쇠고리 </a></li>
                                    <li><a href="#">이어캡 </a></li>
                                    <li><a href="#">스트랩 </a></li>
                                    <li><a href="#">반지/목걸이</a></li>
                                    <li><a href="#">팔찌/브로치</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div className="panel panel-default">
                        <div className="panel-heading">
                            <h4 className="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#2">
                                    <span className="badge pull-right"><i className="fa fa-plus"></i></span>
											의류
										</a>
                            </h4>
                        </div>
                        <div id="2" className="panel-collapse collapse">
                            <div className="panel-body">
                                <ul>
                                    <li><a href="#">티셔츠</a></li>
                                    <li><a href="#">후드집업</a></li>
                                    <li><a href="#">자켓</a></li>
                                    <li><a href="#">바람막이</a></li>
                                    <li><a href="#">져지</a></li>
                                    <li><a href="#">청바지</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div className="panel panel-default">
                        <div className="panel-heading">
                            <h4 className="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#3">
                                    <span className="badge pull-right"><i className="fa fa-plus"></i></span>
											생활용품
										</a>
                            </h4>
                        </div>
                        <div id="3" className="panel-collapse collapse">
                            <div className="panel-body">
                                <ul>
                                    <li><a href="#">안경/안경소품</a></li>
                                    <li><a href="#">안경닦이</a></li>
                                    <li><a href="#">컵</a></li>
                                    <li><a href="#">타올</a></li>
                                    <li><a href="#">쿠션커버</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div className="panel panel-default">
                        <div className="panel-heading">
                            <h4 className="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#4">
                                    <span className="badge pull-right"><i className="fa fa-plus"></i></span>
											패션소품
										</a>
                            </h4>
                        </div>
                        <div id="4" className="panel-collapse collapse">
                            <div className="panel-body">
                                <ul>
                                    <li><a href="#">토트백</a></li>
                                    <li><a href="#">메신저백</a></li>
                                    <li><a href="#">백팩</a></li>
                                    <li><a href="#">카드케이스</a></li>
                                    <li><a href="#">지갑/파우치</a></li>
                                    <li><a href="#">넥타이</a></li>
                                    <li><a href="#">와펜</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div className="panel panel-default">
                        <div className="panel-heading">
                            <h4 className="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#5">
                                    <span className="badge pull-right"><i className="fa fa-plus"></i></span>
											테피스트리
										</a>
                            </h4>
                        </div>
                        <div id="5" className="panel-collapse collapse">
                            <div className="panel-body">
                                <ul>
                                    <li><a href="#">A1 사이즈</a></li>
                                    <li><a href="#">A2 사이즈</a></li>
                                    <li><a href="#">B1 사이즈</a></li>
                                    <li><a href="#">B2 사이즈</a></li>
                                    <li><a href="#">슬림 사이즈</a></li>
                                    <li><a href="#">캔버스 아트</a></li>
                                    <li><a href="#">등신대</a></li>
                                    <li><a href="#">100cm 사이즈</a></li>
                                    <li><a href="#">200cm 사이즈</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div className="panel panel-default">
                        <div className="panel-heading">
                            <h4 className="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#6">
                                    <span className="badge pull-right"><i className="fa fa-plus"></i></span>
											그 외 소품
										</a>
                            </h4>
                        </div>
                        <div id="6" className="panel-collapse collapse">
                            <div className="panel-body">
                                <ul>
                                    <li><a href="#">아크릴 스탠드</a></li>
                                    <li><a href="#">모자</a></li>
                                    <li><a href="#">클리어파일</a></li>
                                    <li><a href="#">개인요청상품</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="brands_products">
                    <h2>프로그램 별</h2>
                    <div className="brands-name">
                        <ul className="nav nav-pills nav-stacked">
                            <li><a href="#"> <span className="pull-right">(50)</span>Acne</a></li>
                            <li><a href="#"> <span className="pull-right">(56)</span>Grüne Erde</a></li>
                            <li><a href="#"> <span className="pull-right">(27)</span>Albiro</a></li>
                            <li><a href="#"> <span className="pull-right">(32)</span>Ronhill</a></li>
                            <li><a href="#"> <span className="pull-right">(5)</span>Oddmolly</a></li>
                            <li><a href="#"> <span className="pull-right">(9)</span>Boudestijn</a></li>
                            <li><a href="#"> <span className="pull-right">(4)</span>Rösch creative culture</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        )
    }
}