import { Component, OnInit } from '@angular/core';
import { Post } from './model/post';
import { PostService } from './service/post.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'frontend';
  posts: Post[] = [];

  constructor(private service: PostService) { }

  ngOnInit(): void {
    console.log('init app..');
    this.service.getPosts().subscribe(rst => {
      // console.log('getting posts:', rst);
      this.posts = rst.map(raw => {
        let post = new Post();
        return Object.assign(post, raw);
      });
      // console.log('print this.posts', this.posts);
    }, err => {
      console.error('error getting posts.', err);
    })
  }

}
