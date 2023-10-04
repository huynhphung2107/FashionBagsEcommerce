import axiosClient from './axiosClient';

const colorAPI = {
  getAll(pageNum, pageSize) {
    const url = '/color/';
    return axiosClient.get(url, {
      params: {
        page: pageNum,
        size: pageSize,
      },
    });
  },
  get(id) {
    const url = `/color?id=${id}`;
    return axiosClient.get(url);
  },
  add(data) {
    const url = `/color`;
    return axiosClient.post(url, data, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
  },
  update(data) {
    const url = `/color?id=${data.id}`;
    return axiosClient.put(url, data);
  },
  delete(id) {
    const url = `/color?id=${id}`;
    return axiosClient.delete(url);
  },
};

export default colorAPI;
