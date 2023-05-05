import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class BreadcrumbService {

  breadcrumb: { name: string; url: string }[] = [];

  constructor(public router: Router, private route: ActivatedRoute) {}

  setBreadcrumb(data: { name: string; url: string }[]) {
    this.breadcrumb = data;
  }

  generateBreadcrumb() {
    const routes = this.route.snapshot['_routerState'].url.split('/');
    const breadcrumbs = [];
console.log(routes)
    routes.forEach((route, index) => {
      const routePath = routes.slice(0, index + 1).join('/');
      if (route) {
        breadcrumbs.push({
          name: route,
          url: routePath
        });
      }
    });
console.log(breadcrumbs)
    this.breadcrumb = breadcrumbs;
    console.log(this.breadcrumb)
  }
}
