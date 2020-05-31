import React from 'react'
import ReactDOM from 'react-dom';
<<<<<<< HEAD
<<<<<<< HEAD
import ItemCard2 from '../items/itemCard2.jsx';
import VoteResult from './voteResult.jsx'
import './votePreShow.css'
import './css/voteDoShow.css'
=======
import ItemCard from '../items/itemCard.jsx';
import ItemCard2 from '../items/ItemCard2.jsx';
import './voteShow.css'
>>>>>>> jaeyoung
=======
import ItemCard from '../items/itemCard.jsx';
import './voteShow.css'
>>>>>>> parent of 877a2626... Merge branch 'minseok'
const axios = require('axios');

var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];
// url.substr(url.length-1,1);

const regeneratorRuntime = require("regenerator-runtime");


class VoteShow extends React.Component {
    constructor(props){
        super(props);
<<<<<<< HEAD
    }
    
    render() {
        // {this.sendSelect.bind(this,index)}
        return this.props.votes.map((vote,index)=>{
            if (vote.name != 0){
                return (
                    <div key={vote.name+index} className="card_div" onClick={this.props.event.bind(this,index)}> 
                        {/* <ItemCard key={vote.img} img={vote.img} name={vote.name} event={this.sendSelect.bind(this,index)}/>   */}
                        <ItemCard2 key={vote.img} img={vote.img} name={vote.name}/>
                    </div>
                )
            }
        })
    }
}

class Show extends React.Component{

    constructor(props){
        super(props);
<<<<<<< HEAD
        this.state = { votes: [], title: "",program:{img:"검정고무신.png",name:"검정고무신"},date:{startTime:"000",endTime:"0000"}};
        this.aa = "aaa";
        this.edTime;//종료 시간
        this.stTime;//현재시간, 타이머 시작 시간
        this.rmTime= 10 ;// 종료시간 - 현재시간

        this.divStTime;// 투표기간 표시 ( 시작날짜 )
        this.divEdTime;// 투표기간 표시 ( 마감 날짜 )

=======
        this.state = { votes: [], title: ""};
        this.aa = "aaa";
>>>>>>> jaeyoung
    }

    async componentDidMount(){
        let {data} = await axios.get('/vote/axios/'+param);
        // console.log(data[0]);
<<<<<<< HEAD
        this.setState({votes : data[0], title : data[1], program:data[2], date : data[3]});
        console.log(data);

        this.edTime = this.parseTime();
        this.stTime = new Date().getTime();
        this.rmTime = this.edTime - this.stTime;
        console.log("edTime:"+this.edTime+"\n"+"stTime: "+this.stTime+"\n"+"rmTime:"+this.rmTime)
        var that = this;
        // this.rmTime=10000;
        var interval  = setInterval(function(){
            that.timer(interval);
        },1000)
        
    }
    // asd
    parseTime(){
        var time = this.state.date.endTime;
        console.log(time);
        var y = time.substr(0,4);
        var m = time.substr(4,2)
        var d = time.substr(6,2);
        var h = time. substr(8,2);
        var mm = time. substr(10,2);
        
        return new Date(y+"-"+m+"-"+d+" "+h+":"+mm).getTime()
        
    }
    timer(interval){
        
        var hours = Math.floor(this.rmTime/(1000*60*60))
        // Math.floor((this.rmTime % (1000 * 60 * 60 * 24)) / (1000*60*60));
        // console.log("(this.rmTime % (1000 * 60 * 60 * 24)) / (1000*60*60): "+(this.rmTime % (1000 * 60 * 60 * 24)) / (1000*60*60))
        var miniutes = Math.floor((this.rmTime % (1000 * 60 * 60)) / (1000*60));
        var seconds = Math.floor((this.rmTime % (1000 * 60)) / 1000);
        
        var m = hours + " : " +  miniutes + " : " + seconds ; // 남은 시간 text형태로 변경
        // console.log(m);
        // document.all.timer.innerHTML = m;   // div 영역에 보여줌 
        document.getElementById("circleTimer").innerHTML = m
=======
        this.setState({votes : data[0], title : data[1]});
        // console.log(this.state);
>>>>>>> jaeyoung
=======
        this.state = { votes: [] };
    }

    async componentDidMount(){
        let {data : votes} = await axios.get('/vote/axios/'+param);
        
        this.setState({votes});
        // console.log(this.state);
>>>>>>> parent of 877a2626... Merge branch 'minseok'
        
    }

    sendSelect(index){
        const select  =  {"select" : index+1}
        console.log(select);

        axios.post('/vote/axios/'+param, select)
        .then((response)=>{
            if(response.data.errorMessage){
                alert(response.data.errorMessage);
                window.location.href="/vote";
            }else{
                alert(response.data.message);
                window.location.href="/vote";
            }
        });
        

    }
<<<<<<< HEAD
<<<<<<< HEAD
    setDate(){
        // console.log("set")
        var start = this.state.date.startTime;
        var end = this.state.date.endTime;
=======
>>>>>>> parent of 877a2626... Merge branch 'minseok'


    render() {
        const { votes } = this.state
        console.log(votes);
        return votes.map((vote,index)=>{
            if (vote.name != 0){
                return (
                    <div key={vote.name+index} className="card_div"> 
                        <ItemCard key={vote.img} img={vote.img} name={vote.name} event={this.sendSelect.bind(this,index)}/>  
                    </div>
                )
            }
        })
    }
}

function Show(){
        return(
            <div>
                <div><a href="/vote">목록으로 가기</a></div>
                <VoteShow/>
                
<<<<<<< HEAD
                <div className="list_a_tag"><a href="/vote">목록</a></div>
                <div className="div_center"><h3>{title}</h3></div>
                <div id="voteDate">
                    <div className="text_center br_div">투표기간</div>
                    <div className="text_center">시작: {this.divStTime}</div>
                    <div className="text_center">마감: {this.divEdTime}</div>
                </div>
                <div className="left_right_box">
                    <div id="item">
                        <div className="candidate">&lt;&lt; 후보 정보 &gt;&gt;</div>
                        <div className="candidate_op">★☆후보 클릭 시 투표가능☆★</div>
                        <div className="cards">
                            <VoteShow votes={this.state.votes} event={this.sendSelect} />   
                        </div>
                    </div>        
                    <div className="right_div_box">
                        <div className="show_result">★☆실시간 투표 결과☆★</div>
                        <div className="vote_result">
                            <VoteResult/>
                        </div>
                        
                    </div>
                </div>
                     
=======
    render(){
        const {title} = this.state.title
        return(
            <div>
                <h2>투표</h2>
                <div><a href="/vote">목록으로 가기</a></div>
                <div><h3>{title}</h3></div>
                <VoteShow votes={this.state.votes} event={this.sendSelect}/>                
>>>>>>> jaeyoung
=======
>>>>>>> parent of 877a2626... Merge branch 'minseok'
            </div>
        )
}

ReactDOM.render(<Show/>,document.getElementById('voteShow'));
