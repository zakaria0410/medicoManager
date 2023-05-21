import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Accept':'*/*'

  })
};
@Injectable({
  providedIn: 'root'
})
export class GenericClientService {
private readonly baseUrl = 'http://localhost:8080/api/' ;
  constructor(private http:HttpClient) { }

  public get(path:any):Observable<any>{
    return this.http.get<any>(this.baseUrl+path, httpOptions);
  }
  public post(path:any,object):Observable<any>{
    return this.http.post<any>(this.baseUrl+path,object, httpOptions);
  }
  public postFile(path:any,object):Observable<any>{
    let httpOptionMultipart = {
      headers: new HttpHeaders({
        "Content-Type": "multipart/form-data"
    
      })
    };
    
    return this.http.post<any>(this.baseUrl+path,object,httpOptionMultipart);
  }
  upload(file,path): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file);
    const req = new HttpRequest('POST', `${this.baseUrl}${path}`, formData, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }
  download(path): Observable<Blob> {
    return this.http.get(`${this.baseUrl}${path}`, {
      responseType: 'blob'
    });
  }

  public listAll(path:any):Observable<any>{
    return this.http.get<any>(this.baseUrl+path+"/all", httpOptions);
  }
  public listAllEnabled(path:any):Observable<any>{
    return this.http.get<any>(this.baseUrl+path+"/all/enabled", httpOptions);
  }
save(object:any,path):Observable<any>{

  return this.http.post<any>(this.baseUrl+path,object, httpOptions);
}
saveRef(object:any,path):Observable<any>{
  return this.http.post<any>(this.baseUrl+path+'/saveRef',object, httpOptions);
}
update(object:any,id:any,path):Observable<any>{

    return this.http.put<any>(this.baseUrl+path+'/'+id,object, httpOptions);
  }
delete(id:any,path):Observable<any>{
  return this.http.delete<any>(this.baseUrl+path+'/'+id, httpOptions);
}
}
